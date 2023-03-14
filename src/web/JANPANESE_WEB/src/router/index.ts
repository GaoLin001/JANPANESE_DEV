import Vue from 'vue'
import VueRouter from "vue-router";
import Login from "../views/Login.vue";

Vue.use(VueRouter)

const routes = [
  {
    path: "/",
    name: "Login",
    component: Login,
  },
  {
    path: '/first',
    component: () => import('../views/First.vue'),
    name: 'First',
    meta: { title: '主页', icon: 'first' },
    redirect: '/index',
    children:[
      {
        path: '/index',
        component: () => import('../views/index.vue'),
        name: 'Index',
        meta: { title: '右侧', icon: 'index' },
      }
    ]
  },
  {
    path: '/logon',
    component: () => import('../views/Logon.vue'),
    name: 'Logon',
    meta: { title: '注册', icon: 'logon' },
  },
];

// // 公共路由
// export const constantRoutes = [
//   {
//     path: '/user',
//     hidden: true,
//     redirect: 'noredirect',
//     children: [
//       {
//         path: '/first',
//         component: () => import('../views/First.vue'),
//         name: 'First',
//         meta: { title: 'diyi', icon: 'first' }
//       }
//     ]
//   }
// ]

const router = new VueRouter({
  mode : 'history',
  routes
})

export default router
