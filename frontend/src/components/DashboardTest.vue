
<template id="app">
  <ul>
    <li v-for="currency in currencies" :key="currency.id">
      {{ currency.code }}
    </li>
  </ul>
</template>

<script>
import Vue from 'vue'
import api from '../Api.js'

new Vue({
  el: '#app',
  mounted() {
    api.getAll().then(response => console.log(response))
    // (response => this.currencies = response.data)
  },
  data: {
    currencies: null
  }
})
export default {
  name: 'DashboardTest',
}
</script>
