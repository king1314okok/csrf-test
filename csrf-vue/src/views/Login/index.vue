<template>
  <el-form ref="form" :model="form" label-width="80px" class="main">
    <el-form-item label="用户名">
      <el-input v-model="form.username"></el-input>
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model="form.password"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="login">登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import axios from "axios"
import qs from 'qs'

export default {
  name: "login",
  data () {
    return {
      form: {
        username: "",
        password: ""
      }
    };
  },
  methods: {
    login () {
      axios.post('/csrf/doLogin', qs.stringify(this.form)).then(res => {
        const data = res.data
        if (!data.success) {
          this.$message(data.msg)
        } else {
          this.$message(data.msg)
          sessionStorage.setItem('loginStatus',JSON.stringify(res.data.result))
          setTimeout(() => {
            window.location = '/'
          }, 1000)
        }
        console.log(data)
      }).catch(error => {
        console.log(error)
      });
    }
  }
};
</script>

<style scoped>
.main {
  width: 500px;
  margin: 0 auto;
}
</style>
