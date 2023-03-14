import request from '@/utils/request'

// 登录方法
export function doInit_api(username, userPass) {
    const data = {
        username,
        userPass
    }
    return request({
        url: '/init',
        method: 'post',
        data: data
    })
}