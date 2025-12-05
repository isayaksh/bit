# Bit Coin Monitoring Service

Bithumb API를 사용하여 암호화폐 거래 페어 정보를 가져오는 스프링 배치 애플리케이션입니다.

## 주요 기능

- Bithumb Public API의 거래 페어 정보를 조회합니다.
- Spring Batch를 사용하여 주기적으로 데이터를 가져오는 작업을 수행합니다.
- Spring WebFlux의 `WebClient`를 사용하여 비동기 HTTP 요청을 처리합니다.

## 사용 기술

- **언어**: Kotlin
- **프레임워크**: Spring Boot, Spring Batch
- **HTTP 클라이언트**: Spring WebFlux (`WebClient`)
- **데이터베이스**: H2 (In-memory)
- **빌드 도구**: Gradle

## 실행 방법

프로젝트를 빌드하고 실행하기 위해 아래 명령어를 사용합니다.

```bash
./gradlew bootRun
```

애플리케이션이 시작되면 배치 작업이 실행됩니다.

## 배치 작업 (Batch Job)

### `tradingPairsJob`

이 배치 작업은 거래 페어 정보를 가져오는 단일 스텝(`tradingPairsStep`)으로 구성됩니다.

- **Reader**: `TradingPairsReader`
  - `https://api.bithumb.com/public/trading-pairs` 엔드포인트에서 거래 페어 정보를 읽어옵니다.
  - `WebClient`를 사용하여 API를 호출합니다.
  - 더 이상 읽을 데이터가 없으면 `null`을 반환하여 읽기 작업을 종료합니다.

- **Processor**: `TradingPairsProcessor`
  - Reader에서 읽어온 `TradingPairsDTO.Data` 객체를 `TradingPair` 엔티티로 변환합니다.

- **Writer**: `JpaItemWriter`
  - Processor가 변환한 `TradingPair` 엔티티를 H2 데이터베이스에 저장합니다.

## 설정 (Configuration)

주요 설정은 `src/main/resources/application.properties` 파일에서 관리할 수 있습니다.

- **API Base URL**: Bithumb API의 기본 URL이 `WebClientConfig`에 설정되어 있습니다.
- **데이터베이스**: H2 인메모리 데이터베이스를 사용하며, `spring.h2.console.enabled=true`로 설정하여 웹 콘솔을 통해 데이터베이스를 확인할 수 있습니다. (접속 URL: `http://localhost:8080/h2-console`)