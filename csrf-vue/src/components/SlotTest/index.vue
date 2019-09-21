<template>
  <div>
    <h1>子组件开始</h1>
    <slot name="header"></slot>
    <div>子组件中间</div>
    <slot name="tableData" :data="childData"></slot>
  </div>
</template>

<script>
export default {
  name: "slot-test",
  data () {
    return {
      childData: [
        {
          date: "2016-05-02",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1518 弄"
        },
        {
          date: "2016-05-04",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1517 弄"
        },
        {
          date: "2016-05-01",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1519 弄"
        },
        {
          date: "2016-05-03",
          name: "王小虎",
          address: "海市普陀区金沙江路 1516 弄"
        },
        {
          date: "2016-05-06",
          name: "王小虎",
          address: "上海市普陀区金沙江路 1520 弄"
        }
      ]
    };
  },
  methods: {}
};
</script>
