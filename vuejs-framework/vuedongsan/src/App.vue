<template>
  <img alt="Vue logo" src="./assets/logo.png">
  https://www.youtube.com/watch?v=T4N9wjx7_E4&list=PLfLgtT94nNq3Br68sEe26jkOqCPK_8UQ-&index=4
  <div>원룸샵</div>
  <div>
    <h4 class="red" :style="스타일">{{ products[0] }}</h4>
    <p>{{ prices[0] }} 만원</p>
  </div>
  <div>
    <h4 class="red" :style="스타일">{{ products[1] }}</h4>
    <p>{{ prices[1] }} 만원</p>
  </div>
  <div>
    <h4 class="red" :style="스타일">{{ products[2] }}</h4>
    <p>{{ prices[2] }} 만원</p>
  </div>

</template>

<script>


export default {
  name: 'App',
  data() {
    return {
      prices : [60, 70, 80],
      products : ['역삼동원룸', '천호동원룸', '마포구원룸'],
      스타일 : 'bold'
    }
  },
  components: {
  }
}

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
