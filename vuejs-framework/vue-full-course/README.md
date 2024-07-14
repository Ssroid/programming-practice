# Vue 3 + Vite

This template should help get you started developing with Vue 3 in Vite. The template uses Vue 3 `<script setup>` SFCs, check out the [script setup docs](https://v3.vuejs.org/api/sfc-script-setup.html#sfc-script-setup) to learn more.

Learn more about IDE Support for Vue in the [Vue Docs Scaling up Guide](https://vuejs.org/guide/scaling-up/tooling.html#ide-support).

# Vue 시작하기
## 초기화
```
npm install vite@latest
프로젝트 명 : vue-full-cource
framework : vue
js : javascript
```

```
npm install
```

## Vue 실행
```
npm run dev
```

# LifeCycle(App1)
### BeforeCreated()
- OptionsAPI에서 렌더러가 컴포넌트를 생성하기 전에 작동하는 함수
  - this를 사용해도 data와 methods를 사용X

### Created()
- 렌더러가 컴포넌트를 생성한 이후에 작동하는 함수

### beforeMounted() 
- DOM이 렌더링이 되지 않아 HTML 요소에 아직 접근하지 못할 때 작동하는 함수

### mounted()
- DOM이 렌더링이 된 후에 해당 HTML 요소에 접근이 가능할 때 작동하는 함수

# 바인딩(App2)
### 데이터 바인딩
- 데이터 바인딩은 안에 HTML 요소를 넣어도 텍스트 그대로 해석
  - 따라서, v-html 태그를 활용하여 해당 요소에 html을 삽입하도록 함.

### 클래스 바인딩
- 클래스 값에 bool을 통해 class 속성 값을 조절할 수 있음.

### 스타일 바인딩
- style 태그에 자주 사용하는 변수를 활용하여 CSS를 활용 가능

# 조건부 및 리스트 렌더링(App3)
### 조건부 렌더링
- [v-if, v-else-if, v-else] vs v-show
- v-if는 활성화됬을 때만 렌더링이 되고, false일땐 렌더링 X
- v-show는 항상 DOM에 렌더링이 됨.

### 리스트 렌더링
- vue3 에서는 리스트 렌더링 사용 시 :key 속성이 필수이며, 이때의 값에는 중복이 되지 않는 고유값을 설정함.  
ex) id값 또는 idx값 
- v-for 속성을 사용하여 해당 객체에 대한 item들을 불러올 수 있음.
- key값을 통해 DOM이 렌더링할 때 부하가 적어짐. 키값의 비교를 통해 변경된 사항만을 파악할 수 있음.
- v-for의 키값을 할 때 만일 `v-for="(user, index) in users"` 일 떄, `:key="index"`로 해선 안됨.

# 5 핵심문법 2 - Data편
- **인라인 핸들러** : HTML Element 내에 어떤 기능을 동작하는 코드를 직접 할당

- **메소드 핸들러** : 컴포넌트 Script 부분에 정의된 methods 부분에 할당

- Computed란?
  - 정의 : return 시키는 데이터를 사용하기 때문에 methods 방식과 비슷하지만, 미리 복잡한 함수에 대한 처리를 수행하여 반복적으로 처리하는 것을 방지
  - 사용 이유 : 너무 많은 연산 행위 또는 HTML 안에 처리하면 코드가 비대해지기도 하고 유지보수가 어려워, 연산이 복잡한 경우 미리 계산된 데이터 형태로 저장
  - methods 차이점 : methods는 함수를 호출만 만큼 횟수, computed는 미리 데이터 로직을 수행하여 저장 -> 반복 로직 X(Caching)
- Watch란?
  - 정의 : 어떤 데이터를 감시하고 있다가, 그 데이터가 변경되었을 때 감지되어 어떠한 이벤트 행위를 하는 것
  - Example : 페이지네이션 번호를 변경할 때, 선택한 리스트만 변경할 때, 리스트만 감지하여 리스트 내용이 변경되도록 하는 것

- Props란?
  - 정의 : 상위 컴포넌트에서 선언된 것을 하위 컴포넌트에서 사용할 때
  - 전체 조건 : 하위 컴포넌트가 존재
  - 데이터 흐름 : 상위 -> 하위
  - 사용방법 : OptionsAPI - props {}, CompositionAPI : defineProps
  - 

- Emits란?
  - 정의 : 하위 컴포넌트에서 선언된 것을 상위 컴포넌트에서 사용할 때
  - 전체 조건 : 상위 컴포넌트가 존재
  - 데이터 흐름 : 하위 -> 상위
  - 사용 방법 : OptionsAPI - this.$emits, CompositionAPI : defineEmits

- v-model란?
  - 정의 : 양방향 데이터 바인딩을 가능토록하는 디렉티브
  - Props와 Emits가 동시에 진행된다고 이해하면 됨.
  - 가장 많이 사용되는 태그는 input 태그

### 5.1 이벤트 핸들러
- @click은 v-on 디렉티브를 사용 : v-on:click=""

### 5.2 Computed
- methods는 함수 호출마다 해당 함수를 반복적으로 호출
- computed는 미리 로직을 캐싱해서 함수를 호출할 때 아까 캐싱한 로직을 반환
  - computed는 함수에 반드시 `return`이 존재해야함!
> 이는 함수부분에 console.log를 통해 개발자도구로 확인가능
- computed는 함수 로직이지만 반환값은 값 형태이므로, 호출할 때 함수로 하지 않고 변수 호출식으로 함.
- 최종적으로, **복잡한 함수가 자주 호출이 되서 사이트에 대한 부하가 있을 시에 미리 캐싱하여 호출하도록 함.**

### 5.3 Watch
- watch 옵션을 통해 데이터 변경에 반응하기 보다 일반적인 방법
- 데이터 변경에 대한 응답으로 비동기식 또는 시간이 많이 소요되는 조작을 수행에 적합
- 특정 속성이 변경시점에 특정 액션등을 취하고자 할 때 적합
- 변경되고자 하는 부분을 감지하고자 하면 함수명을 **해당 이름**으로 설정해야 함.
ex. message 값의 변경을 감지하고자 할 때 watch에서 message()를 생성하여 로직을 작동해야 함.
- 값 뿐만 아니라 computed로 계산된 값도 watch로 감지할 수 있음.
- 게시판에서 한 컬럼을 선택할 때, 고유한 id값이 변경될 때 그 id 값에 따른 상세 데이터를 호출할 때, 주로 사용

### 5.4 Props / Emits
- props는 부모 컴포넌트로 부터 값을 가져오기에 readonly만 가능함.
  - 데이터 타입은 변경할 수 있으나, 값의 수정 X
- emit은 첫번째 인자에 이벤트 이름, 두번째 인자에는 보낼 데이터

- Props는 하위컴포넌트를 import 받고 html에 선언해서 v-bind 태그는 생략 가능
> Ctrl + Shift + L : 드래그 단어가 같은 단어들을 한번에 선택

- 반응성을 가지는 타입이 필요할 떄는 ref를 선언
- 반응성을 가지는 객체일 때는 ref를 써도 무관하지만, reactive를 권장
> TypeScript에서 객체에 대한 타입을 설정할 때는 interface를 구성해서 각각의 데이터에 타입을 지정해서 객체의 타입을 넣도록 함.

