<template>
  <h1>{{ text }}</h1>
  <h1>changeText 함수 호출 값: {{ changeText() }}</h1>
  <h1>changeText 함수 호출 값: {{ changeText() }}</h1>
  <h1>changeText 함수 호출 값: {{ computedText }}</h1>
  <h1>changeText 함수 호출 값: {{ computedText }}</h1>
</template>

<script>
export default {
  data () {

    return {
      text: "Computed 테스트 데이터 문구입니다.",
    }
  },
  computed: {
    computedText() {
      console.log("computedText 함수 호출");
      return this.text.split('').reverse().join('');
    },
  },

  methods: {
    changeText() {
      console.log("함수 호출");
      console.log(this.text);

      return this.text.split('').reverse().join('');
    },
  }
}
</script>

<style lang="scss" scoped>

</style>