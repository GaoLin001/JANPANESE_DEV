<template>
  <nav>
    <div className="logo"><img src=""></div>
    <div className="el-menu-item" href="#" style="margin-left: 10px;white-space: nowrap">MG</div>

  </nav>
</template>
<script>
export default {
  name: "Navbar"
}
</script>

<style lang="css">
nav {
  display: flex;
  align-items: center;
  justify-content: center;
}

nav .el-menu-item {
  color: #FFFFFF;
  padding: 15px 100px;
  position: relative;
  text-align: center;
  border-bottom: transparent;
  display: flex;
  transition: 0.4s;
  font-size: larger;
  font-weight: bold;
}

nav .el-menu-item:hover {
  background-color: darkgray;
  border-bottom: solid 6px;
  border-bottom-color: brown;
  height: 10px;
}
</style>
