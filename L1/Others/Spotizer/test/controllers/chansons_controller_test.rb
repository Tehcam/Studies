require 'test_helper'

class ChansonsControllerTest < ActionDispatch::IntegrationTest
  setup do
    @chanson = chansons(:one)
  end

  test "should get index" do
    get chansons_url
    assert_response :success
  end

  test "should get new" do
    get new_chanson_url
    assert_response :success
  end

  test "should create chanson" do
    assert_difference('Chanson.count') do
      post chansons_url, params: { chanson: { date_sortie: @chanson.date_sortie, titre: @chanson.titre } }
    end

    assert_redirected_to chanson_url(Chanson.last)
  end

  test "should show chanson" do
    get chanson_url(@chanson)
    assert_response :success
  end

  test "should get edit" do
    get edit_chanson_url(@chanson)
    assert_response :success
  end

  test "should update chanson" do
    patch chanson_url(@chanson), params: { chanson: { date_sortie: @chanson.date_sortie, titre: @chanson.titre } }
    assert_redirected_to chanson_url(@chanson)
  end

  test "should destroy chanson" do
    assert_difference('Chanson.count', -1) do
      delete chanson_url(@chanson)
    end

    assert_redirected_to chansons_url
  end
end
