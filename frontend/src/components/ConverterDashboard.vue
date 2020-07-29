<template>
  <div class="contanier">
    <div class="wrapper">
      <div class="header">
        <img src="../assets/img/logo.svg" alt="logo" />
        <h1>Currentor</h1>
      </div>
      <div class="dashboard-container">
        <div class="dashboard">
          <h1>Test</h1>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ConverterDashboard',
  props: {},
}
</script>

<style scoped>
* {
  background: #ffffff;
  background: transparent;
  margin: 0;
  padding: 0;
}

body {
  position: relative;
  height: 100%;
}

.contaniner {
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}
.header {
  position: absolute;
  width: 75%;
  height: 7%;
  top: 7px;

  background: #9ac5bd;
  border-radius: 20px;

  display: flex;
  align-items: center;
  justify-content: center;
}

.header h1 {
  position: absolute;

  margin: auto;

  font-family: SF Pro Display;
  font-style: normal;
  font-weight: bold;
  font-size: 50px;
  line-height: 60px;

  color: #ffffff;
}

.header img {
  position: absolute;
  left: 38.5%;
  background: url('../assets/img/logo.svg');
}

.dashboard-container {
  position: absolute;
  width: 75%;
  height: 75%;
  top: 83px;

  background: #ffffff;
  box-shadow: 0px 10px 30px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
}

.wrapper {
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
