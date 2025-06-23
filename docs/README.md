초간단 자동차 경주 게임을 구현한다.

## Requirement
### Move
- car can move or stop
- random number 4 or more -> move

### Name
- car has name
- name is divided by ','
- name length must be under 5

### Winner
- winner should be 1 or more
- divided by ','

## Input
- name of cars
- try count
- if user type wrong input, quit the application after throw IllegalArgumentException

## Output
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```
