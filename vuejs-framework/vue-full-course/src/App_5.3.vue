<template>
  <button  @click="changeMessage">
    {{ message }}
  </button>
  {{ watchMessage }}
</template>

<script>
export default {
  data () {
    

    return {
      message: "안녕하세요, Vue.js watch 기능 테스트 오리지날 문구",
      watchMessage: '',
    }
  },
  watch: {
    message() {
      // window.alert('message 변수에 담긴 message가 변경되었습니다.');
      this.watchMessage = 'Watch 기능 작동'
    },
    id() {
      // id값의 감지될 때 해당 상세데이터를 조회하는 API를 호출할 때 
    }
  },
  methods: {
    changeMessage() {
      console.log('함수 호출');
      this.message = '변경된 message 데이터 입니다.';
    }
  }
}
</script>

<style lang="scss" scoped>

</style>