module.exports = {
    devServer: {
        proxy: {
            'api': {
                target: 'http://localhost:9090',
                changeOrigin:false,
                pathRewrite: {
                    '/api': '/'
                }
            },
            // 'bpi': {
            //     target: 'http://localhost:8858',
            //     changeOrigin:false,
            //     pathRewrite: {
            //         '/bpi': '/'
            //     }
            // },
            'cpi': {
                target: 'http://localhost:9090',
                changeOrigin:false,
                pathRewrite: {
                    '/cpi': '/'
                }
            }
        }
    }
}