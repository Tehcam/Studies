class AddRayonIdToItem < ActiveRecord::Migration[6.0]
  def change
    add_column :items, :rayon_id, :integer
  end
end
