document.addEventListener('DOMContentLoaded', function() {
    const ctx = document.getElementById('fortuneChart').getContext('2d');
    const moneyLuck = parseInt(document.getElementById('moneyLuck').textContent);
    const workLuck = parseInt(document.getElementById('workLuck').textContent);
    const loveLuck = parseInt(document.getElementById('loveLuck').textContent);

    const fortuneChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['金運', '仕事運', '恋愛運'],
            datasets: [{
                label: '運勢',
                data: [moneyLuck, workLuck, loveLuck],
                backgroundColor: [
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    max: 100
                }
            },
            plugins: {
                legend: {
                    display: false
                }
            }
        }
    });
});
