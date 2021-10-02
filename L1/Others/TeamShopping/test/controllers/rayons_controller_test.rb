require 'test_helper'

class RayonsControllerTest < ActionDispatch::IntegrationTest
  setup do
    @rayon = rayons(:one)
  end

  test "should get index" do
    get rayons_url
    assert_response :success
  end

  test "should get new" do
    get new_rayon_url
    assert_response :success
  end

  test "should create rayon" do
    assert_difference('Rayon.count') do
      post rayons_url, params: { rayon: { label: @rayon.label } }
    end

    assert_redirected_to rayon_url(Rayon.last)
  end

  test "should show rayon" do
    get rayon_url(@rayon)
    assert_response :success
  end

  test "should get edit" do
    get edit_rayon_url(@rayon)
    assert_response :success
  end

  test "should update rayon" do
    patch rayon_url(@rayon), params: { rayon: { label: @rayon.label } }
    assert_redirected_to rayon_url(@rayon)
  end

  test "should destroy rayon" do
    assert_difference('Rayon.count', -1) do
      delete rayon_url(@rayon)
    end

    assert_redirected_to rayons_url
  end
end
