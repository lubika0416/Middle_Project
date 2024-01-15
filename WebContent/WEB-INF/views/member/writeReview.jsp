<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>리뷰 작성</title>
    <!-- Bootstrap CSS -->
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
      crossorigin="anonymous"
    />
    <link
      href="<%=request.getContextPath() %>/css/styles.css"
      rel="stylesheet"
    />
    <link href="<%=request.getContextPath() %>/css/font.css" rel="stylesheet" />

    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    />
    <style>
      * {
        font-family: "GmarketSansMedium";
      }
      .input-form {
        max-width: 500px;

        margin-top: 50px;
        padding: 30px;

        background: #fff;
        -webkit-border-radius: 10px;
        -moz-border-radius: 10px;
        border-radius: 10px;
        -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
        -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
        box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      }
      .rate { 
      display: inline-block; 
      border: 0; 
      margin-right: 15px;
      }
	  .rate > input { display: none; }
	  .rate > label { float: right; color: #ddd; }
	  .rate > label:before {
	    display: inline-block;
	    font-size: 2rem;
	    padding: .3rem .2rem;
	    margin: 0;
	    cursor: pointer;
	    font-family: FontAwesome;
	    content: "\f005 ";
	  }
	  .rate .half:before { content: "\f089 "; position: absolute; padding-right: 0; }
	  .rate input:checked ~ label,
	  .rate label:hover,
	  .rate label:hover ~ label { color: var(--CI, #00E577); }
	  .rate input:checked + .rate label:hover,
	  .rate input input:checked ~ label:hover,
	  .rate input:checked ~ .rate label:hover ~ label,
	  .rate label:hover ~ input:checked ~ label { color: var(--CI, #00E577); }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
  </head>
  
  <body>
    <%@include file="../common/mainheader.jsp" %>

    <div class="container">
      <div
        class="input-form-backgroud row"
        style="margin-top: 80px; margin-bottom: 80px"
      >
        <div class="input-form col-md-6 mx-auto" style="padding: 30px">
          <h3 class="mb-4 fw-bold" style="text-align: center">리뷰 작성</h3>
          <form
            class="validation-form"
            novalidate
            method="post"
            action="<%=request.getContextPath()%>/member/review.do"
           	enctype="multipart/form-data"
          >

            <hr class="mb-4" />

            <div class="row" style="display: flex; justify-content: center;">
              <div class="col-md-8 my-2">
                <label for="exampleTextarea" class="form-label">작성 내용</label>
                    <!-- 부트스트랩 5의 form-control 클래스를 적용 -->
                    <textarea class="form-control" id="exampleTextarea" name="reviewContent" rows="5"></textarea>
                              </div>

              <div class="col-md-8 my-2">
                <label for="tel">파일</label>
                <input
                  type="file"
                  class="form-control"
                  id="file"
                  required
                  name="file"
                />
                <div class="invalid-feedback">파일을 선택해주세요.</div>
              </div>
            </div>
            
            <div class="row" style="display: flex; justify-content: center;">
              <div class="col-md-8 my-2 text-center" style=" display: flex; justify-content: space-between; align-items: center;">
              	<label for="rating" class="form-label">별점 등록</label>
                <fieldset class="rate" id="rating" style="margin-right: 70px;">
	                <input type="radio" id="rating10" name="rating" value="10"><label for="rating10" title="5점"></label>
	                <input type="radio" id="rating9" name="rating" value="9"><label class="half" for="rating9" title="4.5점"></label>
	                <input type="radio" id="rating8" name="rating" value="8"><label for="rating8" title="4점"></label>
	                <input type="radio" id="rating7" name="rating" value="7"><label class="half" for="rating7" title="3.5점"></label>
	                <input type="radio" id="rating6" name="rating" value="6"><label for="rating6" title="3점"></label>
	                <input type="radio" id="rating5" name="rating" value="5"><label class="half" for="rating5" title="2.5점"></label>
	                <input type="radio" id="rating4" name="rating" value="4"><label for="rating4" title="2점"></label>
	                <input type="radio" id="rating3" name="rating" value="3"><label class="half" for="rating3" title="1.5점"></label>
	                <input type="radio" id="rating2" name="rating" value="2"><label for="rating2" title="1점"></label>
	                <input type="radio" id="rating1" name="rating" value="1"><label class="half" for="rating1" title="0.5점"></label>
                </fieldset>
              </div>
            </div>

            <hr class="mb-4" />

            

            <div class="mb-4"></div>
            <button
              class="btn btn-primary btn-lg btn-block"
              id="finish"
              type="submit"
            >작성 완료</button>
          </form>
        </div>
      </div>
    </div>


    <!-- Footer-->
    <%@include file="../common/mainfooter.jsp" %>
    
    <script type="text/javascript">
    $('input[name="rating"]').change(function() {
    	  var selectedRating = $('input[name="rating"]:checked').val();
    	});
    </script>
    
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="<%=request.getContextPath()%>/js/scripts.js"></script>
  </body>
</html>
