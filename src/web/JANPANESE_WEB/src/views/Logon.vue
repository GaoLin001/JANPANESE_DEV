<template>
  <el-form :inline="true" style="margin-top: 100px">
    <el-form-item label="用户名　" :model="form">
      <el-input placeholder="请输入用户名称" v-model="form.username"></el-input>
    </el-form-item><br>
    <el-form-item label="密　码　">
      <el-input placeholder="请输入密码" v-model="form.userPass"></el-input>
    </el-form-item><br>
    <el-form-item label="确认密码">
      <el-input placeholder="请再次输入密码" v-model="form.passWord2"></el-input>
    </el-form-item><br>
    <el-form-item label="手机号　">
      <el-input placeholder="请输入手机号" v-model="form.userTel"></el-input>
    </el-form-item><br>
    <el-form-item label="邮箱地址">
      <el-input placeholder="请输入邮箱地址" v-model="form.userEmail"></el-input>
    </el-form-item><br>
    <el-button @click="show">确 认</el-button>
    <el-button @click="canel" v-show="buttonShowOrNotShow">取 消</el-button>
      <el-dialog title="通知" :visible.sync="visible" width="300px">
        <el-form :model="dialogForm">
          <el-form-item>
            <span>{{dialogForm.message}}</span>
          </el-form-item><br>
          <el-form-item>
            <el-button @click="canel" v-show="oKbuttonShowOrNotShow">OK</el-button>
            <el-button @click="closeDia" v-show="canelbuttonShowOrNotShow">Canel</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
  </el-form>
</template>

<script>
import {
  doInit_api,
} from '@/api/logon'
export default {
  name: "Logon",
  data() {
    return {
      // 遮罩层
      visible: false,
      // 选中数组值
      userIds: [],
      // 总条数
      total: 0,
      // 未授权用户数据
      userList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        roleId: undefined,
        userName: undefined,
        phonenumber: undefined
      },
      form: {
        username: null,
        userPass: null,
        passWord2: null,
        userTel: null,
        userEmail: null
      },
      dialogForm: {
        message: null
      },
      buttonShowOrNotShow: false,
      oKbuttonShowOrNotShow: false,
      canelbuttonShowOrNotShow: false,
    };
  },
  methods: {
    show() {
      debugger
      if(this.form.userPass !== null && this.form.passWord2 !== null) {
        if(this.form.userPass === this.form.passWord2){
          debugger
          doInit_api(this.form).then(res => {
            this.dialogForm.message = res.message;
            debugger
            if (res.flag === '1') {
              debugger
              this.oKbuttonShowOrNotShow = false;
              this.canelbuttonShowOrNotShow = true;
              this.buttonShowOrNotShow = true;
            } else {
              this.oKbuttonShowOrNotShow = true;
              this.canelbuttonShowOrNotShow = false;
              this.buttonShowOrNotShow = false;
            }
            this.visible = true;
          }).catch(() => {
          }).finally(() => {
          })
        }
        else {
          debugger
          this.$message.error("两次密码不一致，请重新输入");
          this.form.passWord2 = '';
        }
      }
      else {
        debugger
        this.$message.error("密码没有被输入");
      }
    },
    canel() {
      this.visible = false;
      this.$router.go(-1);
    },
    closeDia() {
      this.visible = false;
    }
  }
}
</script>

<style scoped>

</style>