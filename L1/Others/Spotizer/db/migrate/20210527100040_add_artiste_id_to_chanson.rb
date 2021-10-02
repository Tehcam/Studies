class AddArtisteIdToChanson < ActiveRecord::Migration[6.0]
  def change
    add_column :chansons, :artiste_id, :integer
  end
end
