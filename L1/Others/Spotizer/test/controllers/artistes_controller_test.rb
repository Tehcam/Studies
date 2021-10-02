require 'test_helper'

class ArtistesControllerTest < ActionDispatch::IntegrationTest
  setup do
    @artiste = artistes(:one)
  end

  test "should get index" do
    get artistes_url
    assert_response :success
  end

  test "should get new" do
    get new_artiste_url
    assert_response :success
  end

  test "should create artiste" do
    assert_difference('Artiste.count') do
      post artistes_url, params: { artiste: { nom: @artiste.nom } }
    end

    assert_redirected_to artiste_url(Artiste.last)
  end

  test "should show artiste" do
    get artiste_url(@artiste)
    assert_response :success
  end

  test "should get edit" do
    get edit_artiste_url(@artiste)
    assert_response :success
  end

  test "should update artiste" do
    patch artiste_url(@artiste), params: { artiste: { nom: @artiste.nom } }
    assert_redirected_to artiste_url(@artiste)
  end

  test "should destroy artiste" do
    assert_difference('Artiste.count', -1) do
      delete artiste_url(@artiste)
    end

    assert_redirected_to artistes_url
  end
end
