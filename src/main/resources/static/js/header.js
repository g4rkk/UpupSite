        window.onload = function() {
            // 条件によって表示するか非表示にする要素のIDを指定
            var elementLogin = 'elementLogin';
            var elementLogout = 'elementLogout';

            // ここに条件を記述
            var shouldDisplay = true; // 例: trueなら表示、falseなら非表示

            // 条件に基づいて要素を表示または非表示にする
            var element = document.getElementById(elementId);
            if (element) {
                if (shouldDisplay) {
                    element.style.display = 'block';
                } else {
                    element.style.display = 'none';
                }
            }
        }
        
          // ボタンの表示を切り替える関数
  function updateButtonVisibility() {
    const loginBtn = document.getElementById('loginBtn');
    const logoutBtn = document.getElementById('logoutBtn');

    if (loggedIn) {
      // ログインしている場合
      loginBtn.style.display = 'none';
      logoutBtn.style.display = 'inline-block';
    } else {
      // ログインしていない場合
      loginBtn.style.display = 'inline-block';
      logoutBtn.style.display = 'none';
    }
  }