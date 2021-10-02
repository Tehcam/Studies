class RemoveRayonFromItem < ActiveRecord::Migration[6.0]
  def change
    remove_column :items, :rayon, :string
  end
end
