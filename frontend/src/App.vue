<template>
  <div id="app">
    <!--    <img alt="Vue logo" src="./assets/logo.png">-->
    <!--    <HelloWorld msg="Welcome to Your Vue.js App"/>-->
    <!-- <CurrencyDashboard /> -->
    <DashboardTest />
  </div>
</template>

<script>
// import CurrencyDashboard from './components/ConverterDashboard'
// import HelloWorld from './components/HelloWorld'
import DashboardTest from './components/DashboardTest'


export default {
  name: 'App',
  components: {
    // CurrencyDashboard,
    // HelloWorld
    DashboardTest,
  },
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
