let currentPage = 1;
const pageSize = 10;
console.log(currentPage,pageSize)

console.log(123123)
loadFeedback(currentPage);

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
    axios.get(`/get/user/issues?pageNum=${currentPage}&pageSize=${pageSize}`)
        .then(response => {
            const feedbackContainer = document.getElementById('feedback-container');
            feedbackContainer.innerHTML = '';

            console.log(response.data,11)
            const data = response.data.data.pageIssues;
            console.log(data.pageIssues)
            data.forEach(item => {
                console.log(item)
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

            document.getElementById('page-info').innerHTML = `第 ${currentPage} 页`;
    console.log(document.getElementById('page-info'))
            // Disable buttons conditionally
            document.getElementById('prev-page').disabled = pageNum === 1;
            document.getElementById('next-page').disabled = data.length < pageSize;
        })
        .catch(error => {
            console.error('Error loading feedback:', error);
        });
}