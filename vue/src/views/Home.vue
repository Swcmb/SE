<template>
  <div>
    <div style="font-size: 20px;font-weight: bold;color: red;text-decoration: underline;font-style: italic;margin: 20px">
      欢迎大家跟着青哥哥一起学项目，一起提升自己，实现自己够0到1的突破!
    </div>

    <div style="font-size: 30px">
      {{a}}  {{b}}
    </div>

    <div>
      {{data.a}}
      {{data.b}}
      {{data.c}}
      {{data.d}}
    </div>

    <div>
      <input v-model="data.a" />
    </div>

    <div style="margin-bottom: 20px">
      <span style="color: red" v-if="data.name === '佩奇'" >小猪佩奇</span>
      <span style="color: blue" v-if="data.name === '乔治'" >小猪乔治</span>
      <span style="color: hotpink" v-else>小猪朵朵</span>
    </div>

    <div style="display: flex">
      <div @click="show(item)" style="width: 300px;height:300px;text-align:center;line-height:300px;font-size:30px;margin-right:10px;background-color: green" v-for="item in data.arr">{{item}}</div>
    </div>

    <div>
      <select style="width: 200px">
        <option v-for="item in data.fruits">{{item}}</option>
      </select>
    </div>

    <div style="margin-bottom: 20px">
      <button @click="click">点我加好运</button>
    </div>

    <div>
      <div :style="data.box"></div>
    </div>
  </div>
</template>

<script setup>
import {onMounted, reactive, ref} from "vue";

const a=ref(1)
const b=ref("青哥哥真的很帅")

const data=reactive({
  a:123,
  b:"啊啊啊啊",
  c:"122222222",
  d:false,
  name:'',
  arr:[1,2,3],
  fruits:['苹果','香蕉','橘子'],
  box:{
    width:'100px',
    height:'100px',
    backgroundColor:'yellow'
  }
})

onMounted(()=>{
  console.log('页面加载完成')
})

const click=() =>{
  alert("好运+1")
}

</script>