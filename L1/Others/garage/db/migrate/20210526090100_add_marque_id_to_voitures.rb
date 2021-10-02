class AddMarqueIdToVoitures < ActiveRecord::Migration[6.0]
  def change
    add_column :voitures, :marque_id, :integer
  end
end
