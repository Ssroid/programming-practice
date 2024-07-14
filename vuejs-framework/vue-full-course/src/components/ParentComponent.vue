<template>
  <div>
    <button @click="sendEvent">부모컴포넌트에서 만든 버튼</button>
  </div>
</template>

<script>
// <script setup lang="ts">
// import { ref } from "vue"

// const data = ref<string>("부모컴포넌트에서 선언된 데이터입니다.");
// const emit = defineEmits(["send-event-name"])
// const sendEvent = () => {
//   emit("send-event-name", data.value)
// }
// </script>

export default {
  data() {
    return {
      text: '부모컴포넌트에서 선언된 데이터입니다.',
    }
  },
  methods: {
    sendEvent() {
      this.$emit('send-event-name', this.text);
    }
  }
}

<script>
</script>

<style lang="scss" scoped>

</style>