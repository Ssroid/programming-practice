<template>
  <div>
    <h2>반응형 메시지</h2>
    <p>{{ reactiveMessage }}</p>
    <button v-on:click="addReactiveMessage">Add reactiveMessage</button>
    <h2>노말 메시지</h2>
    <p>{{ noamlMessage }}</p>
    <button v-on:click="addNormalMessage">Add NormalMessage</button>
  </div>
</template>

<script>
import { isRef, onBeforeMount, onMounted, ref } from 'vue';

export default {
  setup() {
    console.log('setup()');
    const reactiveMessage = ref('Hello Reactive Message');
    const addReactiveMessage = () => {
      reactiveMessage.value += '!';
    } 
    // console.log('isRef(reactiveMessage):', isRef(reactiveMessage));

    let noamlMessage = 'Hello Normal Message';
    const addNormalMessage = () => {
      NormalMessage.value += '!';
    } 
    // console.log('isRef(noamlMessage):', isRef(noamlMessage));

    onMounted(() => {
      console.log('onMounted');
    })
    onBeforeMount(() => {
      console.log('onBeforeMounted');
    })


    return {
      reactiveMessage,
      addReactiveMessage,
      addNormalMessage,
      noamlMessage,
    };
  },
};
</script>

<style lang="scss"></style>