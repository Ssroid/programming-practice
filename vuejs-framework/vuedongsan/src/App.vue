<template>

  <div class="menu">
    <a v-for="a in 메뉴들" :key="a">{{ a }}</a>
  </div>
  <div>원룸샵</div>

  <div v-for="(product, i) in products" :key="i">
      <h4 class="red" :style="스타일">{{ product }}</h4>
      <p>{{ prices[i] }} 만원</p>
  </div>

  
  https://www.youtube.com/watch?v=T4N9wjx7_E4&list=PLfLgtT94nNq3Br68sEe26jkOqCPK_8UQ-&index=4
</template>

<script>


export default {
  name: 'App',
  data() {
    return {
      메뉴들 : ["Home", "Products", "About"],
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
  /* margin-top: 60px; */
}

.menu {
  background: darkslateblue;
  padding: 15px;
  border-radius: 5px;
}

.menu > a {
  color: white;
  padding: 10px;
}
</style>
