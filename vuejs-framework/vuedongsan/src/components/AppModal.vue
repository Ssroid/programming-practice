<template>
  <h1>Vue05 - 모달창 만들기</h1>

  <div class="black-bg" v-if="모달창열렸니 == true">
    <div class="white-bg">
      <button style="position: relative; left:300px" @click="모달창열렸니 = false">X</button>
      <h4>상세페이지임</h4>
      <p>상세피이지 내용임</p>
    </div>
  </div>

  <div class="menu">
    <a v-for="a in 메뉴들" :key="a">{{ a }}</a>
  </div>
  <div>원룸샵</div>

  <div v-for="(product, i) in products" :key="i">
    <img :src="show_img(이미지[i])" class="room-img">
    <h4 class="red" :style="스타일" @click="모달창열렸니 = true">{{ product }}</h4>
    <p>{{ prices[i] }} 만원</p>
    <button @click="신고수[i]++">허위매물신고</button> <span>신고 수 : {{ 신고수[i] }}</span>
  </div>
  <!-- 해당 객체를 클릭했을 때의 이벤트 -->
  
  <!-- 마우스 올렸을 때의 이벤트 -->
  <!-- <button @mouseover="신고수 += 1">허위매물신고</button> <span>신고 수 : {{ 신고수 }}</span> -->
</template>

<script>

export default {
  name: 'AppModal',
  data() {
    return {
      모달창열렸니 : false, 
      이미지 : ['room0.jpg', 'room1.jpg', 'room2.jpg'],
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
    },
    show_modal() {
      this.모달창열렸니 = true;
    },
    // 
    show_img(img) {
      return require('../assets/' + img);
    }
  },
  components: {
  }
}

</script>

<style scoped>
* {
  /* font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale; */
  text-align: center;
  color: #2c3e50; 
  /* margin-top: 60px; */
}

body {
  margin: 0;
}

div {
  box-sizing: border-box;
}

.black-bg {
  width: 100%; height: 100%;
  background: rgb(0, 0, 0, 0.5);
  position: fixed; 
  padding: 20px;
}

.white-bg {
  width: 100%; background: white;
  border-radius: 8px;
  padding: 20px;
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

.room-img {
  width: 50%;
  margin-top: 40px;
}

</style>
