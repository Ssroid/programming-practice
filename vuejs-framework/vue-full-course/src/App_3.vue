<template>
  <div>
    <!-- <div v-if="isVisible" class="red"></div>
    <div v-if="isVisible" class="blue"></div>
    <div v-else class="black"></div> -->


    <!-- <div v-if="count" class="red"></div>
    <div v-else class="blue"></div>
    <button @click="count++">증가</button>
    <button @click="count--">감소</button> -->

    <div v-show="isVisible" class="red"> </div>
    <div v-show="!isVisible" class="blue"> </div>
    <div v-if="isVisible" class="black"> </div>
  </div>
</template>

<script>
export default {
  data() {

    return {
      isVisible: false,
      count: 0,
    }
  },
}
</script>

<style>
.red {
  width: 100px;
  height: 100px;
  background-color: red;
}

.blue {
  width: 100px;
  height: 100px;
  background-color: blue;
}

.black {
  width: 100px;
  height: 100px;
  background-color: black;
}

</style>