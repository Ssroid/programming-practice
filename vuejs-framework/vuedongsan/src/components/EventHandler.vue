<template>
  <h1>Vue04 - 이벤트 핸들러 다루기</h1>
  <div class="menu">
    <a v-for="a in 메뉴들" :key="a">{{ a }}</a>
  </div>
  <div>원룸샵</div>

  <div v-for="(product, i) in products" :key="i">
      <h4 class="red" :style="스타일">{{ product }}</h4>
      <p>{{ prices[i] }} 만원</p>
      <button @click="신고수[i]++">허위매물신고</button> <span>신고 수 : {{ 신고수[i] }}</span>
  </div>
  <!-- 해당 객체를 클릭했을 때의 이벤트 -->
  
  <!-- 마우스 올렸을 때의 이벤트 -->
  <!-- <button @mouseover="신고수 += 1">허위매물신고</button> <span>신고 수 : {{ 신고수 }}</span> -->
</template>

<script>

export default {
  name: 'EventHandler',
  data() {
    return {
      신고수 : [0, 0, 0],
      메뉴들 : ["Home", "Products", "About"],
      prices : [60, 70, 80],
      products : ['역삼동원룸', '천호동원룸', '마포구원룸'],
      스타일 : 'bold'
    }
  },
  // make function
  methods: {
    increase() {
      // 해당 객체안의 오브젝트를 사용하려면 this를 사용
      this.신고수 += 1;
    }
  },
  components: {
  }
}

</script>

<style scoped>
* {
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
