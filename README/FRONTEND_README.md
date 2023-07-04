# Frontend

### Requirements

- node 18

### Used Libraries

- `typescript`
- `eslint` → for standarized code style
- `vue 3.2.45`
- `vue-router 4.1.6`
- `vite`
- `pinia`
- `daisyui` → css framework
  → requirements: `tailwindcss`, `postcss`, `autoprefixer`
- `vueuse/core, component`

### Project Structure

```plain text
src
├─── assets
│    └─── assets files
├─── components
│    └─── component files
├─── router
│    └─── index.ts
├─── store
│    └─── index.ts
├─── views
│    └─── main
│         └─── AbcView.vue
├─── App.vue
├─── main.ts
├─── shims-vue.d.ts
├─── style.css
└─── vite-env.d.ts
```

- `/src/assets`

  - 정적 파일(image, css 등)

- `/src/component`

  - 화면 전체가 아닌 부분을 구성하여 재사용 가능한 컴포넌트
  - `<template>` - 화면상 표시할 요소
  - `<script>` - 기능
  - `<style>` - css, scope 선언시 고유 스타일 선언 가능

- `/src/router`

  - 어플리케이션에서 사용할 페이지들의 경로를 지정
  - App.vue의 `<router-view/>`와 연동되어 사용

- `/src/store`

  - vuex 라이브러리 사용위한 폴더
  - 어플리케이션에서 사용되는 모든 데이터를 관리하기 위함

- `/src/views`

  - 실제 view 파일

- `/src/App.vue`

  - 내부 여러 컴포넌트를 불러와서 main.js로 넘겨줌

- `/src/main.ts`

  - npm run serve 실행 시 가장 먼저 실행되는 파일
  - 실행 시 인스턴스를 /public/index.html 의 app에 mount함
