## Vue3 완벽 마스터 기본편 EP_03 | 컴포넌트 이해하기 | 일반 JavaScript가 Vue로 변화하는 과정
[영상보기](https://www.youtube.com/watch?v=z0h-eN6Xb4o)

```
<script type="module" src="./src/main.js"></script>
```

```
npm init -y
npm i vue
npm i vite

npm i @vitejs/plugin-vue

```

### vite.confing.js 파일 생성
[vite.config.js Github](https://github.com/vitejs/vite-plugin-vue/tree/main/packages/plugin-vue)
```
// vite.config.js
import vue from '@vitejs/plugin-vue'

export default {
  plugins: [vue()],
}
```
### 기존 package.json vite 추가
```
"scripts": {
    "dev": "vite",
    "test": "echo \"Error: no test specified\" && exit 1"
  },
```
- dev 키값을 넣기

### npm 서버 키기
```
npm run dev
```