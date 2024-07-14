<template>
  <div>
    지금 창은 자식 컴포넌트 레이아웃
    <parent-component @send-event-name="parentEvent"></parent-component>
  </div>
</template>


<script>

// <script setup lang="ts">
// import ParentComponent from "./components/ParentComponent.vue";

// const parentEvent = (event: string) => {
//   console.log(event)
// }

// </script>

import ParentComponent from "./components/ParentComponent.vue";
export default {
  components: {
    ParentComponent,    
  },
  methods: {
    parentEvent(event) {
      console.log(event)
    },
  },
}
</script>


<style lang="scss" scoped>

</style>