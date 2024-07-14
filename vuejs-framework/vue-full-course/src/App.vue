<template>
  <div>
    <!-- v-for 디렉티브 사용 -->
    <li v-for="(item, index) in samepleArray" :key="item" @click="openDialog(index)">{{ item }} / {{ index }}</li>
    <li v-for="(user, index) in otherArray" :key="user.name">{{ user.id }} / {{ index }}</li>

    <!-- 기전 li 태그 반복 -->
    <!-- <li>{{ samepleArray[0] }}</li> -->
    <!-- <li>{{ samepleArray[1] }}</li> -->
    <!-- <li>{{ samepleArray[2] }}</li> -->
    <!-- <li>{{ samepleArray[3] }}</li> -->
  </div>
</template>

<script>
export default {
  data () {
    

    return {
      samepleArray: ['a', 'b', 'c', 'd'],
      otherArray: [
        { id: 0, name: 'John'},
        { id: 1, name: 'Kim'},
        { id: 2, name: 'Lee'},
        { id: 3, name: 'Park'},
      ],
    }
  }
}
</script>

<style lang="scss" scoped>

</style>