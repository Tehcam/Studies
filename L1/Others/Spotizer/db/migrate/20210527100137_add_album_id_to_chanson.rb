class AddAlbumIdToChanson < ActiveRecord::Migration[6.0]
  def change
    add_column :chansons, :album_id, :integer
  end
end
