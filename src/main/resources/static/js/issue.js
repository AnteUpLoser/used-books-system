let currentPage = 1;
const pageSize = 10;
console.log(currentPage,pageSize)

console.log(123123)
// loadFeedback(currentPage);

    document.getElementById('prev-page').addEventListener('click', () => {
        if (currentPage > 1) {
            currentPage--;
            loadFeedback(currentPage);
        }
    });

    document.getElementById('next-page').addEventListener('click', () => {
        currentPage++;
        loadFeedback(currentPage);
    });


function loadFeedback(currentPage) {
    axios.get(`/get/user/issues?pageNum=1&pageSize=10`)
        .then(response => {
            const feedbackContainer = document.getElementById('feedback-container');
            feedbackContainer.innerHTML = '';
            console.log(response.data)
            const data = response.data.data;
            console.log(data)
            data.forEach(item => {
                const feedbackItem = document.createElement('div');
                feedbackItem.className = 'user-issue';
                feedbackItem.innerHTML = ` <div class="user-information">
                        <div class="uid">用户编号：${item.uid}</div>
                        <div class="username">用户名：Cath${item.username}</div>
                    </div>
                    <div class="issue">Issue:${item.issue}</div>
                    <div class="create-time">${item.createTime}</div>`
                feedbackContainer.appendChild(feedbackItem);
            });

            document.getElementById('page-info').textContent = `第 ${pageNum} 页`;

            // Disable buttons conditionally
            document.getElementById('prev-page').disabled = pageNum === 1;
            document.getElementById('next-page').disabled = data.length < pageSize;
        })
        .catch(error => {
            console.error('Error loading feedback:', error);
        });
}