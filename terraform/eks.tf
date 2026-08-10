module "eks" {
  source  = "terraform-aws-modules/eks/aws"
  version = "~> 21.0"

  name               = "devops-eks"
  kubernetes_version = var.eks_cluster_version

  endpoint_public_access = true

  vpc_id = aws_vpc.main.id

  subnet_ids = aws_subnet.private[*].id

  enable_cluster_creator_admin_permissions = true

  eks_managed_node_groups = {
    default = {
      instance_types = [var.eks_node_instance_type]

      min_size     = var.eks_min_nodes
      max_size     = var.eks_max_nodes
      desired_size = var.eks_desired_nodes
    }
  }

  tags = {
    Project     = var.project_name
    Environment = var.environment
  }
}