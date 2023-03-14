import request from '@/utils/request'

// 登录方法
export function doInit_api(form) {
    debugger
    return request({
        url: '/logon/init',
        method: 'post',
        data: form
    })
}