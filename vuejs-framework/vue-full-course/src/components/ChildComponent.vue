<template>
  <!-- <div>{{ props.sendProps1 }}</div>
  <div>{{ props.sendProps2 }}</div>
  <div>{{ props.sendProps3.id }}</div>
  <div>{{ props.sendProps3.name }}</div> -->
  <div>{{ sendProps1 }}</div>
  <div>{{ sendProps2 }}</div>
  <div>{{ sendProps3.id }}</div>
  <div>{{ sendProps3.name }}</div>

</template>

<script setup lang="ts">
import { toRefs } from 'vue'

interface Obj {
  id: number
  name: string
}

// 1. Composition API에서 타입스크립트를 활용하는 방법
// 1-1. Props 받은 데이터 형식에 맞게 타입을 지정

// Prop 받은 데이터 이름 자체에 미리 선언해둔 타입을 설정

interface Props {
  sendProps1: String,
  sendProps2: Number,
  sendProps3: Obj,
}

// defineProps to Refs 내장함수를 통해 Prop 받은 데이터를 활용하여 템플릿 부분에 호출하여 사용
const props = defineProps<Props>() 
const { sendProps1, sendProps2, sendProps3 } = toRefs(props)

// export default {
//   props: {
//     sendProps1: String,
//     sendProps2: Number,
//     sendProps3: Object,
//   },
//   data () {
    

//     return {}
//   }
// }
</script>

<style lang="scss" scoped>

</style>