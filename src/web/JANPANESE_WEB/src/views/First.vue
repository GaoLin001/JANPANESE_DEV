<template>
  <div class="m-content-display">
    <el-container style="height: 100%">
      <el-header style="height: 30px"><!-- 头部区 -->
        <Navbar/>
        <a  @click="logout">SignOut</a>
      </el-header>
      <!-- 页面主体区域 -->
      <el-container>
        <!-- 侧边栏 -->
        <el-aside width="200px">
          <el-menu
              background-color="#545c64"
              text-color="#fff"
              active-text-color="#ffd04b">
            <el-submenu index="1">
              <template slot="title">
                <i class="el-icon-location"></i>
                <span>导航一</span>
              </template>
              <el-menu-item-group>
                <template slot="title">分组一</template>
                <el-menu-item index="1-1">选项1</el-menu-item>
                <el-menu-item index="1-2">选项2</el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="分组2">
                <el-menu-item index="1-3">选项3</el-menu-item>
              </el-menu-item-group>
              <el-submenu index="1-4">
                <template slot="title">选项4</template>
                <el-menu-item index="1-4-1">选项1</el-menu-item>
              </el-submenu>
            </el-submenu>
            <el-menu-item index="2">
              <i class="el-icon-menu"></i>
              <span slot="title">导航二</span>
            </el-menu-item>
            <el-menu-item index="3" disabled>
              <i class="el-icon-document"></i>
              <span slot="title">导航三</span>
            </el-menu-item>
            <el-menu-item index="4">
              <i class="el-icon-setting"></i>
              <span slot="title">导航四</span>
            </el-menu-item>
            <el-menu-item index="5">
              <i class="el-icon-setting"></i>
              <span slot="title">导航四</span>
            </el-menu-item>
            <el-menu-item index="6">
              <i class="el-icon-setting"></i>
              <span slot="title">导航四</span>
            </el-menu-item>
            <el-menu-item index="7">
              <i class="el-icon-setting"></i>
              <span slot="title">导航四</span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <!-- 右侧内容主体 -->
        <el-main>
          <router-view/>
        </el-main>

      </el-container>
      <el-footer>
        GM股份
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import Navbar from "@/views/Navbar";
export default {
  name : 'first',
  components: {Navbar},
  methods: {
    logout() {
      window.sessionStorage.clear();
      this.$router.go(-1);
    },
  },
};
</script>

<style lang="less" scoped>
.el-header {
  background-color: #373d41;
  display: flex; //设置显示为flex布局
  justify-content: space-between; //设置为flex左右布局
  padding-left: 0; //左内边距为0（Logo贴左边）
  align-items: center; //元素上下居中（防止右边按钮贴上下边）
  color: #fff;
  font-size: 20px;
  > div {
    //内嵌的div样式
    display: flex;
    align-items: center; //Logo和文字上下居中
    span {
      margin-left: 15px; //文字左侧设置间距，防止与Logo紧贴
    }
  }
}
.el-aside {
  background-color: #333744;
  height: 1300px;
}
.el-main {
  background-color: #eaedf1;
}
.el-footer {
  z-index: 500;
  position: fixed;
  bottom: 0;
  width: 100%;
  line-height: 100px;
  color: #999999;
  font-size: 5px;
}
</style>