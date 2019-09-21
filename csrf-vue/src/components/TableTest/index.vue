<template>
  <div class="bg-main">
    <h1>这是父组件</h1>
    <slot-test>
      <template slot="header">
        这是title
      </template>
      <template slot="tableData" slot-scope="tableData">
        <el-table :data="tableData.data" style="width: 100%">
          <el-table-column prop="date" label="日期" width="180"></el-table-column>
          <el-table-column prop="name" label="姓名" width="180"></el-table-column>
          <el-table-column prop="address" label="地址"></el-table-column>
        </el-table>
      </template>
    </slot-test>
  </div>
</template>

<script>
import SlotTest from '@/components/SlotTest';

export default {
  name: 'TableTest',
  data () {
    return {
    }
  },
  methods: {
  },
  components: {
    SlotTest: SlotTest
  }
}
</script>

<style scoped>
.bg-main {
  height: 500px;
  width: 600px;
  margin: 0 auto;
}
</style>
