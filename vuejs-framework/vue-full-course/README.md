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