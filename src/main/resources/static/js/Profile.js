document.addEventListener('DOMContentLoaded', function() {
    // 模拟的 profile 数据
    var profile = {
        choiceGood: 1, // 假设的初始 Good 计数
        choiceBad: 2    // 假设的初始 Bad 计数
    };

    // 获取绘制图表的上下文
    const ctx = document.getElementById('goodBadDoughnutChart').getContext('2d');

    // 创建环形图
const goodBadDoughnutChart = new Chart(ctx, {
    type: 'doughnut',
    data: {
        labels: ['Good', 'Bad'],
        datasets: [{
            label: 'Good vs Bad',
            data: [goodChoise, badChoise], // 使用正确的数据源
            backgroundColor: [
                'rgba(54, 162, 235, 0.6)', // Good 的颜色
                'rgba(255, 99, 132, 0.6)'  // Bad 的颜色
            ],
            borderColor: [
                'rgba(54, 162, 235, 1)', // Good 的边框颜色
                'rgba(255, 99, 132, 1)'  // Bad 的边框颜色
            ],
            borderWidth: 2
        }]
    },
    options: {
        cutout: '50%', // 环形图的中间空白部分的大小
    }
});




    // 全局函数来更新 Good 或 Bad 计数
    window.updateCount = function(type) {
        const increment = type === 'good' ? 1 : -1;
        const countType = type === 'good' ? 'choiceGood' : 'choiceBad';
        profile[countType] += increment;

        // 这里可以添加代码向服务器发送更新请求
        // ...

        // 更新环形图数据
        goodBadDoughnutChart.data.datasets[0].data[0] = profile.choiceGood;
        goodBadDoughnutChart.data.datasets[0].data[1] = profile.choiceBad;
        goodBadDoughnutChart.update();
    };
});
