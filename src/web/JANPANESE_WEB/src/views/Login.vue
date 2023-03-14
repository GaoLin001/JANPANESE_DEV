<template>
  <!-- Login -->
  <div id="login">
    <div id="login-form">
      <h1>登陆界面</h1>
      <label for="username"><i class="el-icon-user-solid" style="color: #c1c1c1"></i></label>
      <input type="text" placeholder="用户名" id="username" autocapitalize="off" v-model.trim=username aria-autocomplete="off">
      <p style="visibility: hidden">用户名为必填选项</p>
      <label for="userPass"><i class="el-icon-right" style="color: #c1c1c1"></i></label>
      <input type="password" placeholder="密码" id="userPass" autocapitalize="off" v-model.trim="userPass">
      <p style="visibility: hidden">密码为必填选项</p>
      <div>
        <el-button type="primary" v-on:click="inputInfo">登录</el-button>
        <el-button type="info" v-on:click="resetInfo">重置</el-button>
      </div>
      <div>
        <a href="/logon">注册</a>
      </div>
    </div>
  </div>
</template>

<script>
import {
  doInit_api,
} from '@/api/login'
export default {
  name: "Login",
  data: function () {
    return {
      username: '',
      userPass: '',
    }
  },
  methods: {
    // 清空当前填写信息
    resetInfo: function () {
      this.username = "";
      this.userPass = "";
    },
    // 验证信息是否正确
    inputInfo () {
      doInit_api(this.username, this.userPass).then(res => {
        debugger
        console.log(res.userName)
        this.$router.push({ path: `/first` })
      }).catch(() => {
      }).finally(() => {
      })
    }
  },
  computed: {

  },
  mounted() {
    // css transition 样式
    let input = document.querySelectorAll("input");
    let label = document.querySelectorAll("label")
    let is = document.querySelectorAll("i");
    for (let i = 0; i < input.length; i++) {
      input[i].addEventListener("click", function () {
        input[i].style.width = '70%';
        input[i].style.transition = '1s';
        label[i].style.width = '70%';
        label[i].style.transition = '1s';
        is[i].style.color = '#037db3';
      })
      input[i].addEventListener("blur", function () {
        input[i].style.width = '60%';
        input[i].style.transition = '1s';
        label[i].style.width = '60%';
        label[i].style.transition = '1s';
        is[i].style.color = '#c1c1c1';
      })
    }
  },
  watch: {
    // // 动态监测,验证 input 中 值的输入
    // username: function f() {
    //   let p = document.querySelectorAll("p");
    //   if (this.userPass.length < 1) {
    //     p[0].innerHTML = "用户名称应大于 1 ";
    //   }
    //   if (this.userPass.length >= 1) {
    //     p[0].style.visibility = "hidden";
    //   }
    //   if (this.userPass.length === 0) {
    //     p[0].style.visibility = "visible";
    //   }
    // },
    // userPass: function f() {
    //   let p = document.querySelectorAll("p");
    //   if (this.userPass.length < 8) {
    //     p[1].style.visibility = "visible";
    //     p[1].innerHTML = "用户密码应大于 8 ";
    //   }
    //   if (this.userPass.length >= 8) {
    //     p[1].style.visibility = "hidden";
    //   }
    //   if (this.userPass.length === 0) {
    //     p[1].innerHTML = "请重新输入密码";
    //     p[1].style.visibility = "visible";
    //   }
    // }
  }
}
</script>

<style lang="less" scoped>
#login {
  width: 100vw;
  height: 100vh;
  overflow: hidden;
  position: relative;
  // 背景图片样式
  background-image: url("../assets/background.jpg");
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center;
  background-size: cover;
}

#login-form {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 50vw;
  min-width: 300px;
  max-width: 400px;
  display: flex;
  flex-direction: column;
  background-color: rgba(0, 0, 0, 0.7);
  border-radius: 15px;
  // 表单 box-shadow 样式 好看
  box-shadow: 0 15px 25px rgba(0, 0, 0, .5);

  h1 {
    width: 60%;
    margin: 50px auto 0;
    color: #c1c1c1;
    text-align: center;
  }

  input {
    width: 60%;
    margin: 0 auto;
    // 注意 border outline 默认值
    outline: none;
    border: none;
    padding: 10px;
    border-bottom: 1px solid #fff;
    background: transparent;
    color: white;
  }

  label {
    width: 60%;
    margin: 0 auto;
    position: relative;
    top: 30px;
    left: -15px;
  }

  div {
    width: 60%;
    margin: 10px auto;
    display: flex;
    justify-content: center;
    align-content: center;
  }

  button {
    // rgba
    background-color: rgba(9, 108, 144, 0.5);
    margin: 10px 25px 40px 25px;
  }

  p {
    width: 60%;
    margin: 8px auto;
    position: relative;
    left: -15px;
    color: #ff0000;
    font-size: 8px;
  }
}
// 浏览器兼容 , 针对谷歌浏览器 默认设置的 奇怪样式
input {
  -webkit-text-fill-color: #ffffff !important;
  transition: background-color 5000s ease-in-out ,width 1s ease-out!important;
}

</style>
