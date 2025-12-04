### Reader
- Spring Batch의 설계 자체가 **“아이템 스트림 처리”** 를 전제로 만들어졌다.
- Reader에서 null을 반환하지 않으면 Reader를 지속적으로 실행하게 된다.
- 즉, Reader에서 null을 반환한다는 것은 **더 이상 읽을 데이터 없음** 을 의미하게 된다.

