<template>
  <div>
    <el-collapse v-model="activeNames" >
      <el-collapse-item :title="'发布时间：'+item.createTime+'-----名称：'+item.name" name="1" v-for="item in listData" :key="item.id">
        <div>发布内容：{{item.content}}</div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>
<script>
export default {
  data(){
    return {
      activeNames: ['1'],

      listData:[]
    }
  },

  created(){
    //调用
    this.getNoticeList()
  },
  methods:{
    getNoticeList(){
      this.request.get("/notice/list").then(res=>{
        this.listData = res.data
      })
    }
  }
}
</script>
