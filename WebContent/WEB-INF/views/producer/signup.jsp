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
    <title>Jdus 회원가입</title>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
    </style>
  </head>
  <script>
    $(function () {
      document.getElementById("id").focus();

      let checkId = false;
      let checkPw = false;
      $("#id").on("focusout", function () {
        let memId = $("#id").val();
        if (memId != "") {
          $.ajax({
            url: "http://localhost:8888/Jdus/checkid.do?id=" + memId,
            type: "get",
            data: {},
            success: function (rsp) {
              if (rsp.result == "true") {
                $("#dispCheckId")
                  .text("사용가능한 아이디입니다.")
                  .css("color", "blue");
                checkId = true;
              } else {
                $("#dispCheckId")
                  .text("사용중인 아이디입니다.")
                  .css("color", "red");
              }
            },
            error: function (xhr) {},
            dataType: "json",
          });
        }
      });

      $("#password").on("focusout", function () {
        const pass = $("#password").val();
        const word = $(this).val();
        if (pass != "") {
          $("#dispCheckPw")
            .text("비밀번호를 다시 한번 입력해주세요.")
            .css("color", "red");
        }
      });

      $("#checkPassword").on("focusout", function () {
        const pass = $("#password").val();
        const word = $(this).val();
        if (pass != "" && word != "") {
          if (pass == word) {
            $("#dispCheckPw")
              .text("비밀번호가 일치합니다.")
              .css("color", "blue");
            checkPw = true;
          } else {
            $("#dispCheckPw")
              .text("비밀번호가 일치하지 않습니다.")
              .css("color", "blue");
          }
        }
      });

      function finish() {
        let agree = $("#aggrement").is(":checked");
        if (checkId && checkPw && agree) {
          $("#finish").removeAttr("disabled");
        } else {
          $("#finish").attr("disabled", true);
        }
      }

      setInterval(finish, 100);

      window.addEventListener(
        "load",
        () => {
          const forms = document.getElementsByClassName("validation-form");
          Array.prototype.filter.call(forms, (form) => {
            form.addEventListener(
              "submit",
              function (event) {
                if (form.checkValidity() === false) {
                  event.preventDefault();
                  event.stopPropagation();
                }
                form.classList.add("was-validated");
              },
              false
            );
          });
        },
        false
      );
    });

    function sample6_execDaumPostcode() {
      new daum.Postcode({
        oncomplete: function (data) {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 각 주소의 노출 규칙에 따라 주소를 조합한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          var addr = ""; // 주소 변수
          var extraAddr = ""; // 참고항목 변수

          //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
          if (data.userSelectedType === "R") {
            // 사용자가 도로명 주소를 선택했을 경우
            addr = data.roadAddress;
          } else {
            // 사용자가 지번 주소를 선택했을 경우(J)
            addr = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if (data.userSelectedType === "R") {
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
              extraAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if (data.buildingName !== "" && data.apartment === "Y") {
              extraAddr +=
                extraAddr !== "" ? ", " + data.buildingName : data.buildingName;
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if (extraAddr !== "") {
              extraAddr = " (" + extraAddr + ")";
            }
            // 조합된 참고항목을 해당 필드에 넣는다.
            document.getElementById("address3").value = extraAddr;
          } else {
            document.getElementById("address3").value = "";
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          document.getElementById("zipCode").value = data.zonecode;
          document.getElementById("address").value = addr;
          // 커서를 상세주소 필드로 이동한다.
          document.getElementById("address2").focus();
        },
      }).open();
    }
  </script>

  <body>
    <%@include file="../common/mainheader.jsp" %>

    <div class="container">
      <div
        class="input-form-backgroud row"
        style="margin-top: 80px; margin-bottom: 80px"
      >
        <div class="input-form col-md-6 mx-auto">
          <h3 class="mb-4 fw-bold">사업자 회원가입</h3>
          <form
            class="validation-form"
            novalidate
            action="<%=request.getContextPath() %>/producer/signup.do"
            method="post"
            enctype="multipart/form-data"
          >
            <div class="row">
              <div class="col-md-8 my-2">
                <label for="id">아이디</label>
                <input
                  type="text"
                  class="form-control"
                  id="id"
                  placeholder=""
                  required
                  name="proId"
                />
                <div class="invalid-feedback">아이디를 입력해주세요.</div>
                <div id="dispCheckId"></div>
              </div>

              <div class="col-md-8 mb-3">
                <label for="password">비밀번호</label>
                <input
                  type="password"
                  class="form-control"
                  id="password"
                  placeholder=""
                  value=""
                  required
                  name="proPw"
                />
                <div class="invalid-feedback">비밀번호를 입력해주세요.</div>
              </div>
              <div class="col-md-8 mb-3">
                <label for="checkPassword">비밀번호 확인</label>
                <input
                  type="password"
                  class="form-control"
                  id="checkPassword"
                  placeholder=""
                  value=""
                  required
                  name="proPw"
                />
                <div class="invalid-feedback">
                  비밀번호가 일치하지 않습니다.
                </div>
                <div id="dispCheckPw"></div>
              </div>
              <div class="col-md-8 mb-3">
                <label for="email">이메일</label>
                <input
                  type="email"
                  class="form-control"
                  id="email"
                  placeholder="you@example.com"
                  required
                  name="proEmail"
                />
                <div class="invalid-feedback">이메일을 입력해주세요.</div>
              </div>
            </div>
            <hr class="mb-4" />

            <div class="row">
              <div class="col-md-8 mb-3">
                <label for="name">이름</label>
                <input
                  type="text"
                  class="form-control"
                  id="name"
                  placeholder=""
                  required
                  name="proName"
                />
                <div class="invalid-feedback">이름을 입력해주세요.</div>
              </div>
              <div class="col-md-8 mb-3">
                <label for="tel">전화번호</label>
                <input
                  type="tel"
                  class="form-control"
                  id="tel"
                  placeholder="010-1234-5678"
                  required
                  name="proTel"
                />
                <div class="invalid-feedback">전화번호를 입력해주세요.</div>
              </div>
            </div>
            <hr class="mb-4" />

            <div class="row">
              <div class="col-md-8 mb-3">
                <label for="storeName">사업장명</label>
                <input
                  type="text"
                  class="form-control"
                  id="storeName"
                  placeholder=""
                  required
                  name="proStore"
                />
                <div class="invalid-feedback">사업장명을 입력해주세요.</div>
              </div>
              <div class="col-md-8 mb-3">
                <label for="storeNum">사업자 등록번호</label>
                <input
                  type="number"
                  class="form-control"
                  id="storeRegNo"
                  placeholder=""
                  required
                  name="proRegNo"
                />
                <div class="invalid-feedback">
                  사업자 등록번호를 입력해주세요.
                </div>
              </div>
              <div class="col-md-8 mb-3">
                <label for="storeTel"
                  >사업장 전화번호<span class="text-muted"
                    >&nbsp;(필수 아님)</span
                  ></label
                >
                <input
                  type="tel"
                  class="form-control"
                  id="storeTel"
                  placeholder="042-123-123 / 010-0000-0000"
                  name="proStrTel"
                />
                <div class="invalid-feedback">
                  사업장 전화번호를 입력해주세요.
                </div>
              </div>

              <div class="row d-flex" style="align-items: center">
                <div class="col-md-8 mb-3">
                  <label for="zipCode">사업장 우편번호</label>
                  <input
                    type="text"
                    class="form-control"
                    id="zipCode"
                    placeholder=""
                    required
                    name="zip"
                  />
                  <div class="invalid-feedback">우편번호를 입력해주세요.</div>
                </div>
                <input
                  class="col"
                  type="button"
                  value="주소찾기"
                  style="margin-top: 15px"
                  onclick="sample6_execDaumPostcode()"
                />
              </div>

              <div class="mb-3">
                <label for="address">사업장 주소</label>
                <input
                  type="text"
                  class="form-control"
                  id="address"
                  placeholder="대전광역시 서구"
                  required
                  name="proAddr"
                />
                <div class="invalid-feedback">주소를 입력해주세요.</div>
              </div>

              <div class="mb-3">
                <label for="address2"
                  >상세주소<span class="text-muted"
                    >&nbsp;(필수 아님)</span
                  ></label
                >
                <input
                  type="text"
                  class="form-control"
                  id="address2"
                  placeholder="상세주소를 입력해주세요."
                  name="proAddr2"
                />
              </div>
              <div class="mb-3" style="display: none;">
                <label for="address3"></label
                >
                <input
                  type="text"
                  class="form-control"
                  id="address3"
                  placeholder=""
                />
              </div>
            </div>
            <hr class="mb-5" />

            <div class="mb-4">
              <label for="profile_img"
                >공방 프로필<span class="text-muted"
                  >&nbsp;(필수 아님)</span
                ></label
              >
              <input
                type="file"
                class="form-control"
                id="profile_img"
                accept="image/*"
                name="file"
                multiple="multiple"
                
              />
              <div class="invalid-feedback">사진을 등록해주세요.</div>
            </div>

            <div class="mb-4">
              <label for="description1"
                >공방 한줄 소개<span class="text-muted"
                  >&nbsp;(필수 아님)</span
                ></label
              >
              <input
                type="text"
                class="form-control"
                id="description1"
                placeholder="공방 한줄 소개를 입력해주세요. (추후 수정 가능)"
                name="proDesc"
              />
            </div>

            <div class="mb-4">
              <div><label for="description2"
                >공방 세부 소개<span class="text-muted"
                  >&nbsp;(필수 아님)</span
                ></label
              ></div>
              <!-- <input
                type="text"
                class="form-control"
                id="description2"
                placeholder="공방 소개를 입력해주세요. (추후 수정 가능)"
                style="height: 100px"
                name="proPro"
              /> -->
              <textarea name="proPro" rows="7" cols="49" placeholder="공방 소개를 입력해주세요. (추후 수정 가능)" style="padding: 15px; border-color: lightgray; border-radius: 10px;"></textarea>
            </div>

            <hr class="mb-4" />
            <div class="custom-control custom-checkbox">
              <input
                type="checkbox"
                class="custom-control-input"
                id="aggrement"
                required
              />
              <label class="custom-control-label" for="aggrement"
                >개인정보 수집 및 이용에 동의합니다.</label
              >
            </div>
            <div class="mb-4"></div>
            <button class="btn btn-primary btn-lg btn-block" id="finish" type="submit" disabled>
              가입 완료
            </button>
          </form>
        </div>
      </div>
    </div>
    <script>
      window.addEventListener(
        "load",
        () => {
          const forms = document.getElementsByClassName("validation-form");

          Array.prototype.filter.call(forms, (form) => {
            form.addEventListener(
              "submit",
              function (event) {
                if (form.checkValidity() === false) {
                  event.preventDefault();
                  event.stopPropagation();
                }

                form.classList.add("was-validated");
              },
              false
            );
          });
        },
        false
      );
    </script>

    <!-- Footer-->
    <%@include file="../common/mainfooter.jsp" %>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="<%=request.getContextPath()%>/js/scripts.js"></script>
  </body>
</html>
