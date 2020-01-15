module.exports = {
    devServer: {
        host: '0.0.0.0',
        port: 8081, // 端口号
        https: false, // https:{type:Boolean}
        open: false, //配置自动启动浏览器
        proxy: {
            'api': {
                target: 'http://localhost:9090',
                changeOrigin:false,
                pathRewrite: {
                    '/api': '/'
                }
            },
            'bpi': {
                target: 'http://localhost:8858',
                changeOrigin:false,
                pathRewrite: {
                    '/bpi': '/'
                }
            }
        }
    }
}