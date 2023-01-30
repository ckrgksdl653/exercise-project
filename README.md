# exercise-backend
### 1. 환경 구성
1. github에 push 함
2. 자동으로 빌드가 유발되면서 파이프라인이 실행됨
3. harbor에 올리기 전에 도커 이미지를 만듦
4. harbor에 업로드
5. 운영환경에 deploy

### 2. 스프링부트 도커 환경 테스트

### 3. maria DB를 통한 환경 테스트

### 4. Redis 통한 환경 테스트



### 환경 구성에 필요한 job
- 로컬에서 dockerfile 만든 다음에, 빌드 및 기동 후 테스트
- jenkins에서 dockerfile을 보고 도커파일 빌드한 다음에 harbor에 push
- mariaDB 환경 구축
  - yml 파일 사용
- jenkins에서 dockerfile 또는 docker-compose 파일로 빌드한 다음에 harbor에 push
- application.yml은 profile을 구성해서 사용할 수 있도록 수정

