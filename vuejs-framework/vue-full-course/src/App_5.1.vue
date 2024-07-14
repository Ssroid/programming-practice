<template>
  <div>
    <button @click="count++">인라인 핸들러</button>
    <h1>{{ count }}</h1>

    <button v-on:click="changeName">메소드 핸들러</button>
    <h1>{{ name }}</h1>
  </div>
</template>

<script>
export default {
  data() {
    
    return {
      count: 0,
      name: 'Vue.js',
    }
  },
  methods: {
    changeName() {
      this.name = this.name + '!';
    }
  },
}
</script>

<style lang="scss" scoped>

</style>